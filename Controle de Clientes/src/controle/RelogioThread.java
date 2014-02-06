package controle;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;

public class RelogioThread{

	private static JLabel  label; // label onde ser� impressa a hora atual

	public RelogioThread(){//construtor
		label = new JLabel();//instancia o label
		iniciaRelogio();//inicia o rel�gio
	}

	public static JLabel getLabel() {
		new RelogioThread();
		return label;
	}

public void iniciaRelogio(){
	new Thread(){//instancia nova thread j� implementando o m�todo run()
		@Override
		public void run() {//sobrescreve o m�todo run()

			while(true){//while para fazer o loop infinito
				GregorianCalendar gc = new GregorianCalendar();//novo gregorian calendar, onde temos a data atual
				int hora = gc.get(Calendar.HOUR_OF_DAY);//pega as horas
				int minuto = gc.get(Calendar.MINUTE);//pega os minutos
				int segundo = gc.get(Calendar.SECOND);//pega os segundos
				String horaString;//nova string horas
				String minString;//nova string minutos
				String segundoString;//nova string segundos
				if(hora < 10){//se hora for menor que 10 precisa colocar um 0 � esquerda
					horaString = "0"+hora;
				}else{
					horaString = ""+hora;
				}
				if(minuto < 10){//se minuto for menor que 10 precisa colocar um 0 � esquerda
					minString = "0"+minuto;
				}else{
					minString = ""+minuto;
				}
				if(segundo < 10){//se segundo for menor que 10 precisa colocar um 0 � esquerda
					segundoString = "0"+segundo;
				}else{
					segundoString = ""+segundo;
				}
				label.setText(horaString+":"+minString+":"+segundoString);//seta hora atual no label
				try{
					sleep(1000);//faz a thread entrar em estado de espera por 1000 milissegundos ou 1 segundo
				}catch(Exception e){}
			}
		}
	}.start();//inicia a thread.
}

}

