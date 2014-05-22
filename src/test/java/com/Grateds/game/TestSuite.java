package com.Grateds.game;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.Grateds.game.AI.AdversaryStateTest;
import com.Grateds.game.MODEL.BoardTest;
import com.Grateds.game.MODEL.GameStateTest;

@RunWith(Suite.class)
@SuiteClasses({ AppTest.class, BoardTest.class, GameStateTest.class, AdversaryStateTest.class })
public class TestSuite {
	
	/* empty class */

}