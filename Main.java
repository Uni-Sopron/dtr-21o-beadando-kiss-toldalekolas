import java.util.Scanner;

class Main{
 
    public static void main(String[] args) {
    int state = 0;
    String charset = "ISO-8859-1";
    Scanner sc = new Scanner(System.in, charset);
    String input = sc.next();
    System.out.println(input);
    
    for (int i = 0; i < input.length(); i++) {
        //ház - ad / am / á / unk / atok / aik - ban
        switch(state){
            case 0: switch (input.charAt(i)){
                case 'h': state = 1; break;
                default: state = 0; break;
            } break;
            case 1: switch (input.charAt(i)){
                case 'á': state = 2; break;
                case 'h': state = 1; break;
                default: state = 0; break;
            } break;
            case 2: switch (input.charAt(i)){
                case 'z': state = 3; break;
                case 'h': state = 1; break;
                default: state = 0; break;
            } break;
            case 3: switch (input.charAt(i)){ //elfogadó allapot
                case 'z': state = 3; break;
                case 'b': state = 5; break; //itt így megy az "empty-vel" tovább?
                case 'a': state = 8; break;
                case 'u': state = 12; break;
                case 'á': state = 11; break;
                //case 'h': state = 1; break; //elfogadó állapotban vissza megy h-val?
                default: state = 3; break; //ha bármi mást kap, akkor marad itt
            } break;
            case 4: switch (input.charAt(i)){ 
                case 'b': state = 5; break;//itt így megy az "empty-vel" tovább?
                case 'h': state = 1; break;
                default: state = 0; break;
            } break;
            case 5: switch (input.charAt(i)){
                case 'a': state = 6; break;
                case 'h': state = 1; break;
                default: state = 0; break;
            } break;
            case 6: switch (input.charAt(i)){ //elfogadó allapot
                case 'n': state = 7; break;
                //case 'h': state = 1; break;
                default: state = 6; break;
            } break;
            case 7: switch (input.charAt(i)){ //elfogadó allapot
                //case 'h': state = 1; break;
                default: state = 7; break;
            } break;
            case 8: switch (input.charAt(i)){
                case 'd': state = 9; break;
                case 'm': state = 10; break;
                case 't': state = 15; break;
                case 'i': state = 18; break;
                case 'h': state = 1; break;
                default: state = 0; break;
            } break;
            case 9: switch (input.charAt(i)){ //elfogadó allapot
                case 'b': state = 5; break; //itt így megy az "empty-vel" tovább?
                //case 'h': state = 1; break;
                default: state = 9; break;
            } break;
            case 10: switch (input.charAt(i)){ //elfogadó állapot
                case 'b': state = 5; break;
                //case 'h': state = 1; break;
                default: state = 10; break;
            } break;
            case 11: switch (input.charAt(i)){ //elfogadó allapot
                case 'b': state = 5; break;
                //case 'h': state = 1; break;
                default: state = 11; break;
            } break;
            case 12: switch (input.charAt(i)){
                case 'n': state = 13; break;
                case 'h': state = 1; break;
                default: state = 0; break;
            } break;
            case 13: switch (input.charAt(i)){
                case 'k': state = 14; break;
                case 'h': state = 1; break;
                default: state = 0; break;
            } break;
            case 14: switch (input.charAt(i)){ //elfogadó allapot
                case 'b': state = 5; break;
                //case 'h': state = 1; break;
                default: state = 14; break;
            } break;
            case 15: switch (input.charAt(i)){
                case 'o': state = 16; break;
                case 'h': state = 1; break;
                default: state = 0; break;
            } break;
            case 16: switch (input.charAt(i)){
                case 'k': state = 17; break;
                case 'h': state = 1; break;
                default: state = 0; break;
            } break;
            case 17: switch (input.charAt(i)){ //elfogadó allapot
                case 'b': state = 5; break;
                //case 'h': state = 1; break;
                default: state = 17; break;
            } break;
            case 18: switch (input.charAt(i)){
                case 'k': state = 19; break;
                case 'h': state = 1; break;
                default: state = 0; break;
            } break;
            case 19: switch (input.charAt(i)){ //elfogadó allapot
                case 'b': state = 5; break;
                //case 'h': state = 1; break;
                default: state = 19; break;
            } break;
        }
    }
    System.out.println(state == 3 || state == 6 || state == 7 || state == 9 
    || state == 10 || state == 14 || state == 17 || state == 19? "Elfogadva":"Nem elfogadva");
    }
}