package Audio;

import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.*;

public class MusicPlayer implements Runnable {

	private ArrayList<String> musicFiles;
	private int currentSongIndex;

	public MusicPlayer(String... files) {
		musicFiles = new ArrayList<String>();
		for(String file : files) {
			musicFiles.add("./libs/audio/" + file + ".wav");
		}
	}
	private void playSound(String fileName) {
		try {
			File soundFile = new File(fileName);
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
			AudioFormat format = ais.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			Clip clip = (Clip) AudioSystem.getLine(info);
			clip.open(ais);
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-10);
			clip.start();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		playSound(musicFiles.get(currentSongIndex));
	}
}
