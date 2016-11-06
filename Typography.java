/*
Author: Luke Molloy
Desc: A java typography program that mimics a human
      typing a message into notepad. Using the Robot package
*/

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;

public class Typography {

    public static void main(String[] args){
        try{
            // opens notepad
            Runtime.getRuntime().exec("notepad.exe");

        }
        catch(IOException ex){
            ex.printStackTrace();
            System.out.println("There was an issue starting notepad.exe");
        }

        try{
            String username = System.getProperty("user.name");  // getting users name
            Robot r = new Robot();
            // delay to allow notepad to start
            r.delay(2000);
            String msg = "Hello " + username + " and welcome to notepad.";

            for(int a = 0; a < msg.length(); a++){
                // getting keycode for current character and its keycode
                char cur_char = msg.charAt(a);
                int write = KeyEvent.getExtendedKeyCodeForChar(cur_char);
                r.keyPress(write);

                // random duration between letters typed to mimic human behavior
                Random rand = new Random();
                int num = rand.nextInt(200 - 1 + 1) + 1;
                r.delay(num);
            }

        }
        catch(AWTException e){
            e.printStackTrace();

        }
    }
}