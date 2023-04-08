package xshape.eventObserver;

import xshape.renderers.AwtCanva;
import xshape.renderers.AwtRenderer;
import xshape.renderers.Renderer;
import xshape.shapes.Shape;
import xshape.utils.MyColor;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventHandlerAWT implements MouseListener,EventHandlerInterface {

    private Renderer renderer;
    private Observer observer;
    private AwtCanva canva;

    public EventHandlerAWT(Renderer renderer, Observer observer, AwtCanva canva) {
        this.renderer = renderer;
        this.observer = observer;
        this.canva = canva;
    }


    @Override
    public void updateCanva(){
        ((AwtRenderer) renderer).getCanva().repaint();
    }

    @Override
    public void addMoListener(){
        canva.addMouseListener(this);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        for (Shape s:
                renderer.getShapes()) {
            if(s.belongsTo(e.getPoint())){
                observer.updateShapeColor(s, MyColor.ORANGE);
                    updateCanva();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for(Shape s: renderer.get_shapesToolBar()){
            if(s.belongsTo(e.getPoint())){
                renderer.setShapeSelected(s);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Shape selected = renderer.getShapeSelected();
        if (selected != null) {
            selected.setPos(e.getPoint());
            observer.updateShapePosition(selected,e.getX(),e.getY());
            if (renderer instanceof AwtRenderer) {
                ((AwtRenderer) renderer).getCanva().repaint();
            }
            renderer.setShapeSelected(null);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
