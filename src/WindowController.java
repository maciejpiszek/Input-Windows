import java.awt.event.ActionEvent;

public class WindowController {


    private WindowModel windowModel;
    private WindowView windowView;
    
    
    public WindowController() {
    	
        this.windowModel = new WindowModel(this);
        this.windowView = new WindowView(this);   
        
    }
    
    
    public void start() {
    	    	
    	windowView.startWindow();  
    	
    }
    
    
    public static void main (String [] args) {
    	
    	WindowController controller = new WindowController();
    	controller.start();
    	
    }
    
    
	public void onButtonClickStart (ActionEvent e) {
				
		windowView = new WindowView(this);
		windowModel.addWindowToList(windowView);
		WindowView localWindow = windowModel.getWindow(windowModel.getChildWindowsListSize()-1);
		localWindow.setData(windowModel.getJoinedData());
		localWindow.childWindow();
		
	}


	public void onButtonClickChild (ActionEvent e) {
				
		for (int i=0; i<windowModel.getChildWindowsListSize(); i++) {			
			
				windowModel.addData(windowModel.getWindow(i).getData());	
				
		}
		
		for (int i=0; i<windowModel.getChildWindowsListSize(); i++) {	
			
				windowModel.getWindow(i).setData(windowModel.getJoinedData());
				windowModel.getWindow(i).resetInput();
				
		}		
	}
}
