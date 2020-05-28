
package demo;

import mpicbg.spim.data.SpimDataException;
import net.imglib2.labkit.BasicLabelingComponent;
import net.imglib2.labkit.inputimage.SpimDataInputImage;
import net.imglib2.labkit.models.ImageLabelingModel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * This example because it uses a multiview big data viewer dataset. But I
 * consider Labkit to work only on a dataset with one view.
 */
public class LabelingComponentHdf5Demo {

	public static void main(String... args) throws SpimDataException {
		JFrame frame = initFrame();
		final String fn = LabelingComponentHdf5Demo.class.getResource("/export.xml").getPath();
		frame.add(initLabelingComponent(frame, fn));
		frame.setVisible(true);
	}

	private static JFrame initFrame() {
		JFrame frame = new JFrame();
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		return frame;
	}

	private static JComponent initLabelingComponent(JFrame frame,
		String filename)
	{
		ImageLabelingModel model = new ImageLabelingModel(new SpimDataInputImage(filename, 0));
		BasicLabelingComponent labelingComponent = new BasicLabelingComponent(frame, model);
		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				labelingComponent.close();
			}
		});
		return labelingComponent.getComponent();
	}

}
