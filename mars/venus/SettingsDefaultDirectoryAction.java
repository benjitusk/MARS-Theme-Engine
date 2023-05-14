package mars.venus;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import mars.Globals;
import themeengine.DemoPrefs;
import themeengine.IJThemesPanel;

public class SettingsDefaultDirectoryAction extends GuiAction {

	JFileChooser f;
	

	JDialog themesDialog;

	protected SettingsDefaultDirectoryAction(String name, Icon icon, String descrip, Integer mnemonic, KeyStroke accel,
			VenusUI gui) {
		super(name, icon, descrip, mnemonic, accel, gui);
	}

	/**
	 * When this action is triggered, launch a dialog to view and modify editor
	 * settings.
	 */
	@Override
	public void actionPerformed(final ActionEvent e) {
		// Create the directory chooser. It is not shown by default.
		f = new JFileChooser();
		// Set the default directory to the current default directory
		f.setCurrentDirectory(new File(Globals.getSettings().getEditorDefaultDirectory()));
		f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		f.setDialogTitle("Select Default Directory");
		f.setApproveButtonText("Select");
		f.setApproveButtonToolTipText("Select this directory as the default directory");
		f.setMultiSelectionEnabled(false);
		f.setFileHidingEnabled(true);
		f.setAcceptAllFileFilterUsed(false);
		f.showOpenDialog(Globals.getGui());
		// If the user selected a directory, set it as the default directory
		Globals.getSettings().setEditorDefaultDirectory(f.getSelectedFile().getAbsolutePath());
		// f.addActionListener((event) -> {
		// 	if (event.getActionCommand().equals("ApproveSelection")) {
		// 		System.out.println("Selected: " + f.getSelectedFile().getAbsolutePath());
		// 		// Globals.setDefaultDirectory(f.getSelectedFile().getAbsolutePath());
		// 	}
		// });
	}

}
