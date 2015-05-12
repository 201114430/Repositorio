package torreHanoi;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Fondo extends JButton{
	int x;
	int y;
	int ancho;
	int alto;
	public Fondo(int x,int y, int ancho, int alto){//constructor de la clase le envio la posicion donde quiero que aparesca y el tamaño
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		setBorderPainted(false);
	    setContentAreaFilled(false);
	    setBounds(x,y,ancho,alto);
	    setLayout(null);
		String urlImagenTorre = "/Imagen/f4.png";
	    ImageIcon icon = new ImageIcon(getClass().getResource(urlImagenTorre));
	    Image img = icon.getImage();
	    Image otraimg = img.getScaledInstance(1024,630,java.awt.Image.SCALE_SMOOTH);
	    ImageIcon otroicon = new ImageIcon(otraimg);
	    setIcon(otroicon);
	}
}