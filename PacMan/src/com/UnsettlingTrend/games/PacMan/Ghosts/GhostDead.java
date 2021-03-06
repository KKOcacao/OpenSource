package com.UnsettlingTrend.games.PacMan.Ghosts;
import java.util.Random;

import com.UnsettlingTrend.games.PacMan.PCPanel;

public class GhostDead implements GhostState{
	public String getState() {
		return "dead";
	}

	public void Update(Ghost ghost, PCPanel panel)
        {
            int x = ghost.getLocation().x;
            int y = ghost.getLocation().y;
            int direction = ghost.getDirection();
            int xmove = 0;
            int ymove = 0;
            int ms = 5;
            int tmpdirection = direction;
            int nummoves = 0;
            int cage_x = 290;
            int cage_y = 330;
            int priority[] = {-1,-1,-1,-1};
            
            if((x == 290) && (y == 270)){
                ghost.setEntering();
            }
            
            else{

            if(direction == 0) xmove = ms;
            else if(direction == 90) ymove = -ms;
            else if(direction == 180) xmove = -ms;
            else if(direction == 270) ymove = ms;

            if(ghost.Board.IsLegalMove(x + ms, y)){
                nummoves++;
            }
            if(ghost.Board.IsLegalMove(x - ms, y)){
                nummoves++;
            }
            if(ghost.Board.IsLegalMove(x, y + ms)){
                nummoves++;
            }
            if(ghost.Board.IsLegalMove(x, y - ms)){
                nummoves++;
            }
            if((nummoves == 0) || (nummoves == 1)){
                System.out.println("SOMETHING IS WRONG!!");
            }

            else if(nummoves == 2){
                    while(((ghost.Board.IsLegalMove(x + xmove,y + ymove)) == false)){
                        Random rdir = new Random();
                        tmpdirection = rdir.nextInt(4)* 90;
                        while(((tmpdirection + 180) % 360) == direction){
                            tmpdirection = rdir.nextInt(4)*90;
                        }
                        if(tmpdirection == 0) {xmove = ms;ymove = 0;}
                        else if(tmpdirection == 90) {ymove = -ms;xmove = 0;}
                        else if(tmpdirection == 180) {xmove = -ms;ymove = 0;}
                        else if(tmpdirection == 270) {ymove = ms;xmove = 0;}
                        else { System.out.println("how did I get here?");}
                    }
            }

            else{
                //here we have 3 or more options (though backtrack not allowed)
                // cage x=290, y=330
                if((Math.abs(cage_x - x) > (Math.abs(cage_y - y )))){
                    if((cage_x - x) > 0){priority[0]=0;priority[3]=180;}
                    else{priority[0]=180;priority[3]=0;}
                    if((cage_y - y) > 0){priority[1]=270;priority[2]=90;}
                    else{priority[1]=90;priority[2]=270;}
                }
                else{
                    if((cage_y - y) > 0){priority[0]=270;priority[3]=90;}
                    else{priority[0]=90;priority[3]=270;}
                    if((cage_x - x) > 0){priority[1]=0;priority[2]=180;}
                    else{priority[1]=180;priority[2]=0;}
                }
                
                int count = 0;
                do{
                    if(((priority[count] + 180) % 360) == (direction)) {count++;}
                    if(priority[count] == 0) {xmove = ms;ymove = 0;}
                    else if(priority[count] == 90) {ymove = -ms;xmove = 0;}
                    else if(priority[count] == 180) {xmove = -ms;ymove = 0;}
                    else if(priority[count] == 270) {ymove = ms;xmove = 0;}
                    else { System.out.println("how did I get here?");}
                    count++;
                }while(((ghost.Board.IsLegalMove(x + xmove, y + ymove)) == false));
                
                count--;
                tmpdirection = priority[count];
                /*
                do{ 
                    Random rdir = new Random();
                    tmpdirection = rdir.nextInt(4)* 90;
                    while(((tmpdirection + 180) % 360) == direction){
                        tmpdirection = rdir.nextInt(4)*90;
                    }
                    if(tmpdirection == 0) {xmove = ms;ymove = 0;}
                    else if(tmpdirection == 90) {ymove = -ms;xmove = 0;}
                    else if(tmpdirection == 180) {xmove = -ms;ymove = 0;}
                    else if(tmpdirection == 270) {ymove = ms;xmove = 0;}
                    else { System.out.println("how did I get here?");}

                }while(((Blinky.Board.IsLegalMove(x + xmove,y + ymove)) == false));
                */
            }
            x = ghost.tunnelCheck(x, xmove);
            direction = tmpdirection;
            ghost.setLocation(x + xmove,y + ymove);
            ghost.setDirection(direction);
            
            }

        }
}