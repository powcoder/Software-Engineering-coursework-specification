https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
import java.util.Random;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adam
 */


public class Die {

	private int rolledDie;
	private Random random = new Random();
	
	public Die() {
		roll(); 
	}

	public int roll() {
		
		this.rolledDie = random.nextInt(6) + 1; 
		
		return rolledDie;
	}
	
	public int getFaceValue() {
		return rolledDie;
	}

}
