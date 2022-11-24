/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package event;

/**
 *
 * @author USER
 */
import Charactor.*;

public class Event {
			public static boolean checkHit(Man man,Wave wave,int manSize,int waveHeight){
							if(man.x+manSize>wave.x&&man.x<wave.x) {
								if(man.y+manSize>=wave.y-waveHeight) {
									return true;
								}
							}
							return false;
			}
			
			public static void gameStop(Wave[] wave,Environment[] env) {

			}

}