package torreHanoi;

import javax.swing.*;

class DiscoBoton extends JButton{
	int numDisco;
	public DiscoBoton(int n){
		this.numDisco = n;
        setBorderPainted(true);
        setContentAreaFilled(false);
        setLayout(null);
        setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisco(numDisco))));
	}
	public String imagenDisco(int i) {
		if(numDisco==1)
			return "/Imagen/1.png";
		else if(numDisco==2)
			return "/Imagen/2.png";
		else if(numDisco==3)
			return "/Imagen/3.png";
		else if(numDisco==4)
			return "/Imagen/4.png";
		else if(numDisco==5)
			return "/Imagen/5.png";
		else if(numDisco==6)
			return "/Imagen/6.png";
		else if(numDisco==7)
			return "/Imagen/7.png";
		else if(numDisco==8)
			return "/Imagen/8.png";
		else 
			return "/Imagen/0.png";		
	}
}