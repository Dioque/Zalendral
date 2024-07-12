package org.example.Sistema;

public class FpsSistema implements Runnable{
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



    @Override
    public void run() {
        //this.setFocusable(true);
        System.out.println("Texte");
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double fps = this.fps;
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
                renderizadorSistema.renderizador();
                renderizadorSistema.atualizador();
                posX ++;
            }
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(frames);
                frames = 0;
            }
        }
    }
}
