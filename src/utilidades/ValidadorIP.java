package utilidades;

import java.text.ParseException;
import java.util.StringTokenizer;
import javax.swing.text.DefaultFormatter;

public class ValidadorIP extends DefaultFormatter{
    
    @Override
    public String valueToString(Object value) throws ParseException{
         if (!(value instanceof byte[])) throw new ParseException("No es un byte[]", 0);
         byte[] a = (byte[]) value;
         if (a.length != 4) throw new ParseException("Longitud != 4", 0);
         StringBuilder builder = new StringBuilder();
         for (int i = 0; i < 4; i++)
         {
            int b = a[i];
            if (b < 0) b += 256;
            builder.append(String.valueOf(b));
            if (i < 3) builder.append('.');
         }
         return builder.toString();
    }

    @Override
    public Object stringToValue(String text) throws ParseException{
        StringTokenizer tokenizer = new StringTokenizer(text, ".");
        byte[] a = new byte[4];
        for (int i = 0; i < 4; i++){
           int b = 0;
           if (!tokenizer.hasMoreTokens()) throw new ParseException("Cantidad insuficiente de bytes", 0);
           try{
              b = Integer.parseInt(tokenizer.nextToken());
           }
           catch (NumberFormatException e){
              throw new ParseException("No es un entero", 0);
           }
           if (b < 0 || b >= 256) throw new ParseException("Byte fuera de rango", 0);
           a[i] = (byte) b;
        }
        if (tokenizer.hasMoreTokens()) throw new ParseException("Bytes de sobra", 0);
        return a;
    }
}