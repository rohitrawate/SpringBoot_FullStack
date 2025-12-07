package com.rohit.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

//	  private MarioGame game;
//    private SuperContraGame game;
    private GamingConsole game;
	
	public GameRunner(@Qualifier("SuperContraQualifier") GamingConsole game) {
		this.game = game;
	}

	public void run() {
		System.out.println("Game Running : Game Runner ");
		
		game.up();
		game.down();
		game.left();
		game.right();
	}

}
