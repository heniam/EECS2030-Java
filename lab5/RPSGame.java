package eecs2030.lab5;

/**
 * The class that contains the main method that creates the rock, paper,
 * scissors application.
 *
 */
public class RPSGame {

	/**
	 * This method creates an RPSModel, RPSController, and RPSView to create the
	 * rock, paper, scissors game. You need to set the the model and view on the
	 * controller, and you need to make the view visible.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		// This method creates an RPSModel, RPSController, and RPSView
		RPSModel model = new RPSModel(0);
		RPSController controller = new RPSController();
		RPSView view = new RPSView(controller);
		// the rock, paper, scissors game. You need to set the the model
		controller.setModel(model);
		// and view on the controller
		controller.setView(view);
		// make the view visible.
		view.setVisible(true);
	}

}
