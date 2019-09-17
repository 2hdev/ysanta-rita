package utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JTextField;

public class Validaciones {
    
    //validar longitud del campo
    
    public static boolean Longitud(JTextField campo, int maximo){
        return campo.getText().length()>=maximo; 
    }
    
    //permitir solo números
    public static boolean Numeros(char caracter){
        return Character.isDigit(caracter);
}   
    public static boolean NumerosConComa(String cadena){
        //uso: !Validaciones.NumerosConComa
        return cadena.matches("[^\\d+([,]\\d+)?$]");
    }
    
    //permitir números y letras
     public static boolean NumyLetras(char caracter){
        return Character.toString(caracter).matches("[^0-9a-zA-Z]");
     }
     
     public static boolean NumerosyLetras(char caracter){
         return Character.isLetterOrDigit(caracter);
     }
     
     public static boolean Letras(char caracter){
        //valida letras con caracteres especiales (ej: tildes)
        return Character.toString(caracter).matches("[\\p{L}]+");
     }
     
     public static boolean Simbolos(char caracter){
        return caracter!='.' && caracter!='/' && caracter!='*' && caracter!='&' && caracter!='#' && caracter!='-';
     }
     
     public static boolean Coma(char caracter){
        return caracter!=',';
     }
     
     //permitir solo espacio
     public static boolean Espacio(char caracter){
        return caracter==' ';
     }
     
     //verificar que un campo no sea vacío antes de guardar
    public static boolean CampoVacio(String cadena){
        return cadena.trim().length()==0;
     }
     //verificar si el formato de correo electrónico es válido
    public static boolean CorreoValido(String cadena){
        //if (cadena.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
         return cadena.matches("[-\\w\\.]+@\\w+\\.\\w+");
    }
    
    //verifica si coincide exactamente con la longitud dada por parámetro
    public static boolean longitudValida(String cadena, int longitud){
        return cadena.length()==longitud; 
    }
    
    public static boolean numeroFacturaValido(String cadena){
        return cadena.matches("^\\d{3}-\\d{3}-\\d{7}$");
    }
    
    public static boolean validarFecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            Date date = formatoFecha.parse(fecha);
            Calendar cal = GregorianCalendar.getInstance();
            cal.setTime(date);
            if (cal.get(Calendar.YEAR) <= 1950) {
                return false;
            }
            if(cal.get(Calendar.YEAR) >= LocalDate.now().getYear()){
                return false;
            }            
        }
        catch (ParseException e) {
            return false;
        }
        return true;
    }
    
    public static boolean validarFecha(String fecha, int yearlimite) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            Date date = formatoFecha.parse(fecha);
            Calendar cal = GregorianCalendar.getInstance();
            cal.setTime(date);
            if (cal.get(Calendar.YEAR) <= LocalDate.now().getYear()) {
                if((cal.get(Calendar.MONTH)+1) < LocalDate.now().getMonthValue()){
                    return false;
                }
                else if((cal.get(Calendar.MONTH)+1) == LocalDate.now().getMonthValue()){
                    if(cal.get(Calendar.DAY_OF_MONTH) <= LocalDate.now().getDayOfMonth()){
                        return false;
                    }
                }
            }
            if(cal.get(Calendar.YEAR) >= LocalDate.now().getYear()+50){
                return false;
            }
            
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    
    public static boolean validarIP(String dir) {
         return dir.matches("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                 "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                 "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                 "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
    }
}
