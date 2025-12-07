package com.rohit.learn_spring_framework;

import com.rohit.learn_spring_framework.game.GameRunner;
import com.rohit.learn_spring_framework.game.MarioGame;
import com.rohit.learn_spring_framework.game.PacmanGame;
import com.rohit.learn_spring_framework.game.SuperContraGame;

public class App01GamingBasicJava {

	public static void main(String[] args) {
		
//		var game = new MarioGame();     //1. Obj Creation
//		var game = new SuperContraGame();
		var game = new PacmanGame();    
		
		var gameRunner = new GameRunner(game);  // Game is a dependency of the Gamerunner class
		//2. Obj Creation + Wiring of Dependencies
		gameRunner.run();
 
	}

}
 