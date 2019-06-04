package clases;

public class calculoHorario {

    public calculoHorario() {
    }

    public String sumaHorario(String h1, String h2) {
        String resultado = null;
        String aux1[] = h1.split(":");
        String aux2[] = h2.split(":");

        int hora1 = Integer.parseInt(aux1[0]);
        int min1 = Integer.parseInt(aux1[1]);

        int hora2 = Integer.parseInt(aux2[0]);
        int min2 = Integer.parseInt(aux2[1]);

        int sumamin = min1 + min2;
        int sumHora = hora1 + hora2;

        if (sumamin > 60) {
            sumamin = sumamin - 60;
            sumHora = sumHora + 1;
        } else {
            if (sumamin == 60) {
                sumamin = 0;
                sumHora = sumHora + 1;
            }
        }

        resultado = leftPad(String.valueOf(sumHora), 2, '0').concat(":").concat(leftPad(String.valueOf(sumamin), 2, '0'));

        return resultado;
    }

    public String restaHorario(String h1, String h2) {
        String resultado = null;
        String aux1[] = h1.split(":");
        String aux2[] = h2.split(":");

        int hora1 = Integer.parseInt(aux1[0]);
        int min1 = Integer.parseInt(aux1[1]);

        int hora2 = Integer.parseInt(aux2[0]);
        int min2 = Integer.parseInt(aux2[1]);

        int sumamin = min1 - min2;
        int sumHora = hora1 - hora2;
        
        if(sumamin < 0){
            sumamin = sumamin + 60;
            sumHora = sumHora - 1;
        }
        
         resultado = leftPad(String.valueOf(sumHora), 2, '0').concat(":").concat(leftPad(String.valueOf(sumamin), 2, '0'));
        
        return resultado;
    }

    public String leftPad(String originalString, int length,
            char padCharacter) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() + originalString.length() < length) {
            sb.append(padCharacter);
        }
        sb.append(originalString);
        String paddedString = sb.toString();
        return paddedString;
    }

    public static void main(String[] args) {
        String prueba = new calculoHorario().restaHorario("-04:00", "00:00");
        System.out.println(prueba);
    }

}
