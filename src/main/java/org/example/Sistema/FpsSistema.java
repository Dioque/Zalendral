package org.example.Sistema;

import org.example.Cenas.CenaLogin;

public class FpsSistema{
	
    RenderizadorSistema renderizadorSistema = new RenderizadorSistema();
	
	boolean correndo;
	int fps;
	
	public FpsSistema(boolean correndo, int fps){
		this.correndo = correndo;
		this.fps = fps;
	}

	
	public int posX = 0;
	
	public int getPosX(){
		System.out.println("Possição X = "+posX);
		return posX;
	}
	
	public void mostrarFPS(){
		  new Thread() {
              int fps;

		    @Override
		    public void run() {
		    	
		    	//this.setFocusable(true);
		        System.out.println("Texte");
		        long lastTime = System.nanoTime();
		        long timer = System.currentTimeMillis();
		        final double fps = getFps();
		        double ns = 1000000000 / fps;
		        double delta = 0;
		        int frames = 0;
		        while (correndo) {
		            long now = System.nanoTime();
		            delta += (now - lastTime) / ns;
		            lastTime = now;
		            if (delta >= 1) {
		                frames++;
		                delta--;
		                //renderizadorSistema.renderizador();
		                //renderizadorSistema.atualizador();


                        System.out.println(posX);
		            }
		            if (System.currentTimeMillis() - timer > 1000) {
		                timer += 1000;
		                System.out.println(frames);
		                frames = 0;
		            }
		        }
		    		
		    }
		  }.start();

		}

	public boolean isCorrendo() {
		return correndo;
	}

	public int getFps() {
		return fps;
	}

	public void setCorrendo(boolean correndo) {
		this.correndo = correndo;
	}

	public void setFps(int fps) {
		this.fps = fps;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	
//
//
//
//    @Override
//    public void run() {
//        
//    }
}
