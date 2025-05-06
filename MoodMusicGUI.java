import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

public class MoodMusicGUI extends JFrame implements ActionListener {
    JComboBox<String> moodBox;
    JTextArea outputArea;
    JButton nextBtn;
    String currentMood = "";
    int songIndex = 0;

    public MoodMusicGUI() {
        setTitle("Mood-Based Hindi Music Recommender");
        setSize(500, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel label = new JLabel("Aaj aapka mood kya hai?");
        add(label);

        String[] moods = {"Select Mood", "Happy", "Sad", "Angry", "Relaxed", "Energetic"};
        moodBox = new JComboBox<>(moods);
        add(moodBox);

        JButton recommendBtn = new JButton("Recommend Hindi Songs");
        recommendBtn.addActionListener(this);
        add(recommendBtn);

        nextBtn = new JButton("Next Song");
        nextBtn.addActionListener(this);
        nextBtn.setEnabled(false);
        add(nextBtn);

        outputArea = new JTextArea(10, 38);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea));
    }

    public void actionPerformed(ActionEvent e) {
        String mood = (String) moodBox.getSelectedItem();

        if (e.getSource() != nextBtn) {
            currentMood = mood;
            songIndex = 0;
        }

        try {
            switch (currentMood) {
                case "Happy":
                    outputArea.setText("Mood: Happy\n1. Gallan Goodiyan\n2. Kar Gayi Chull");
                    if (songIndex == 0)
                        Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=jCEdTq3j-0U")); // Gallan Goodiyan
                    else
                        Desktop.getDesktop().browse(new URI("https://youtu.be/iwlUeXLPvf0?si=N-jayf7Tr7Kx3z2x")); // Kar Gayi Chull
                    break;

                case "Sad":
                    outputArea.setText("Mood: Sad\n1. Channa Mereya\n2. Chale Aana");
                    if (songIndex == 0)
                        Desktop.getDesktop().browse(new URI("https://youtu.be/284Ov7ysmfA?si=xaGPJ97f8E851Wv9")); // Channa Mereya
                    else
                        Desktop.getDesktop().browse(new URI("https://youtu.be/mNxd1GEDYiQ?si=VR-92npvZmxnen6W")); // Chale Aana
                    break;

                case "Angry":
                    outputArea.setText("Mood: Angry\n1. Sher Aaya Sher\n2. Jee Karda");
                    if (songIndex == 0)
                        Desktop.getDesktop().browse(new URI("https://youtu.be/M81wneSjQbA?si=fUBS8PFJ-FFMQydq")); // Sher Aaya Sher
                    else
                        Desktop.getDesktop().browse(new URI("https://youtu.be/M81wneSjQbA?si=fUBS8PFJ-FFMQydq")); // Jee Karda
                    break;

                case "Relaxed":
                    outputArea.setText("Mood: Relaxed\n1. Tera Ban Jaunga\n2. Khairiyat");
                    if (songIndex == 0)
                        Desktop.getDesktop().browse(new URI("https://youtu.be/M81wneSjQbA?si=fUBS8PFJ-FFMQydq")); // Tera Ban Jaunga
                    else
                        Desktop.getDesktop().browse(new URI("https://youtu.be/9-AKLAfpjrI?si=phDwQNOEkJq84J1J")); // Khairiyat
                    break;

                case "Energetic":
                    outputArea.setText("Mood: Energetic\n1. Zinda Banda\n2. Dance Ka Bhoot");
                    if (songIndex == 0)
                        Desktop.getDesktop().browse(new URI("https://youtu.be/stjZKBhQ3lg?si=9Dkp03PX8z4M0VAY")); // Zinda Banda
                    else
                        Desktop.getDesktop().browse(new URI("https://youtu.be/xfMN4SpIxIA?si=l_S5kf3gjhUcfBhk")); // Dance Ka Bhoot
                    break;

                default:
                    outputArea.setText("Please select a valid mood.");
                    return;
            }

            songIndex = (songIndex + 1) % 2;
            nextBtn.setEnabled(true);

        } catch (Exception ex) {
            outputArea.setText("Error playing song. Please check your internet connection or try again.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MoodMusicGUI().setVisible(true);
        });
    }
}