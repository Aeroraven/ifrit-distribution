package com.aeroraven.demoA;

import com.aeroraven.ifrit.app.IfritApplication;
import com.aeroraven.ifrit.command.IfritCPSwitchRenderScene;
import com.aeroraven.ifrit.component.IfritButton;
import com.aeroraven.ifrit.component.IfritSprite;
import com.aeroraven.ifrit.component.IfritWindow;
import com.aeroraven.ifrit.core.IfritVectord;
import com.aeroraven.ifrit.scene.IfritScene;
import com.aeroraven.ifrit.shape.IfritShapeFactory;

//RUN IN java -jar instead of IDE
public class DemoA {
	static IfritScene  scene = new IfritScene();
	static IfritSprite component = new IfritSprite();
	static IfritButton btn1 = new IfritButton();
	static IfritButton btn2 = new IfritButton();
	
	static IfritWindow window = new IfritWindow();
	
	static IfritShapeFactory shapeFactory = new IfritShapeFactory();
	static IfritApplication app;
	
	public static void main(String[] args) throws Exception {
		DemoA x = new DemoA();
		x.runApp();
	}
	
	public void runApp() throws Exception {
		app = IfritApplication.createApplication();
		app.getGlobal().setFrameUpdateInterval(10);
		
		scene.setSceneSize(1000, 400);
		
		//Add a triangle
		component.setZDepth(0);
		shapeFactory.primitiveBuilder()
					.setBackColor(255, 0, 0)
					.setForeColor(255,255, 255)
					.createTriangle(
							IfritVectord.val(0.,0.), 
							IfritVectord.val(12.,12.), 
							IfritVectord.val(24.,6.), 0)
					.store();
		component.addPrimitive(shapeFactory.getFinalShape());
		
		//Add a Circle
		shapeFactory.primitiveBuilder()
					.setBackColor(0, 255, 0)
					.setForeColor(255,255, 255)
					.createRound(IfritVectord.val(13.,13.), 5, 0)
					.store();
		component.addPrimitive(shapeFactory.getFinalShape());
		//Add a Rectangle
		shapeFactory.primitiveBuilder()
					.setBackColor(0, 0, 255)
					.setForeColor(255,255, 255)
					.createSolidRectangle(0,IfritVectord.val(13.,13.), 12, 5)
					.store();
		component.addPrimitive(shapeFactory.getFinalShape());
		scene.addComponent("1", component);
		
		//Btn1
		btn1.setZDepth(0);
		shapeFactory.textBuilder()
					.setBackColor(255, 0, 0)
					.setForeColor(255,255, 255)
					.createTextWithRectBorder("Press Right", 0, 20, 15, 5, 1)
					.store();
		btn1.addPrimitive(shapeFactory.getFinalShape(),0);
		shapeFactory.textBuilder()
					.setBackColor(0, 255, 0)
					.setForeColor(255,255, 255)
					.createTextWithRectBorder("Selected", 0, 20, 15, 5, 1)
					.store();
		btn1.addPrimitive(shapeFactory.getFinalShape(),1);
		scene.addComponent("2", btn1);
		
		//Btn2
		btn2.setZDepth(0);
		shapeFactory.textBuilder()
					.setBackColor(255, 0, 0)
					.setForeColor(255,255, 255)
					.createTextWithRectBorder("Press Left", 20, 20, 15, 5, 1)
					.store();
		btn2.addPrimitive(shapeFactory.getFinalShape(),0);
		shapeFactory.textBuilder()
					.setBackColor(0, 255, 0)
					.setForeColor(255,255, 255)
					.createTextWithRectBorder("Selected", 20, 20, 15, 5, 1)
					.store();
		btn2.addPrimitive(shapeFactory.getFinalShape(),1);
		scene.addComponent("3", btn2);
		
		app.getMediator().addCommand(new IfritCPSwitchRenderScene(scene));
	}

}
