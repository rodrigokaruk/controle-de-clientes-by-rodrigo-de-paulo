package controle;

import java.awt.Label;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DatadeHj {
	private static Label data;
	
	public DatadeHj(){
		data = new Label();
		GregorianCalendar gc = new GregorianCalendar();//novo gregorian calendar, onde temos a data atual
		int dia = gc.get(Calendar.DAY_OF_MONTH);//pega o dia
		int mes = gc.get(Calendar.MONTH);//pega o mes
		int ano = gc.get(Calendar.YEAR);//pega o ano
		if(dia < 10 && mes < 10){
			data.setText("0"+dia+"/"+"0"+(mes+1)+"/"+ano);
		}
		else if(dia < 10 && mes >= 10){
			data.setText("0"+dia+"/"+(mes+1)+"/"+ano);
		}
		else if(dia >= 10 && mes < 10){
			data.setText(dia+"/"+"0"+(mes+1)+"/"+ano);
		}
		else{
		data.setText(dia+"/"+(mes+1)+"/"+ano);
		}
	}
	
	public static Label getData() {
		new DatadeHj();
		return data;
	}
}
