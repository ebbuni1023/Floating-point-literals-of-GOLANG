public class StateDiagram {
    public static void main(String[] args) {
      String num = "0231.4e-123";
      String temp1="";
      String temp2="";
      boolean flag = false;
      for (int i=0; i< num.length(); i++){
          if (num.charAt(i) == 'x' | num.charAt(i) == 'X') {
            for (int j=0; j<num.length(); j++) {
              if (num.charAt(j) == 'e' | num.charAt(j) == 'E') {
                  flag = true;
                  break;
              }
            }
          }
      }
      if (flag) {
          for (int i=0; i< num.length(); i++) {
            
            if (num.charAt(i) == '+' || num.charAt(i) == '-') {
              for (int j=i+1; j<num.length(); j++) {
                temp2+= Character.toString(num.charAt(j));
              }
              break;
            }
            temp1 += Character.toString(num.charAt(i));
          }
          System.out.println(temp1);
          System.out.println(temp2);
          if (FloatingDiagram(temp1) || FloatingDiagram(temp2)) {
  
            System.out.println("This is a floating point (Special case)");
          } else System.out.println("This is NOT (case) a floating point");
      } else
      if (!flag) { 
      if (FloatingDiagram(num)) {
        System.out.println("This is a floating point");
      } else System.out.println("This is NOT a floating point");
      }
    }
    public static boolean FloatingDiagram(String num) {
    FloatingState current = FloatingState.state0; 
    for (int i=0; i< num.length(); i++) {
      switch(current) {
     
      case state0:  // checked!
       if ((int) num.charAt(i)>= 49 && (int) num.charAt(i) <=57) { 
          current = FloatingState.state1;
       } else if (num.charAt(i) == '.') {
         current = FloatingState.state7;
       } else if ((int) num.charAt(i) == 48) {
         current = FloatingState.state9;
       } else return false;
         break;
      case state1:  // checked!
      if (num.charAt(i) == '_') {
         if (!((int) num.charAt(i+1)>= 48 && (int) num.charAt(i+1) <=57)) {
           return false;
         }
      } else
      if ((int) num.charAt(i)>= 48 && (int) num.charAt(i) <=57) {
        current = FloatingState.state1;
      } else if (num.charAt(i) == '.') {
         current = FloatingState.state2;
      } else if (num.charAt(i) == 'E' | num.charAt(i) == 'e') {
        current = FloatingState.state3;
      } else return false;
         break;
  
      case state2:
      if ((int) num.charAt(i)>= 48 && (int) num.charAt(i) <=57) {
        current = FloatingState.state2;
      } else if (num.charAt(i) == 'E' | num.charAt(i) == 'e') {
        current = FloatingState.state3;
      } 
       else return false;
       break;
      case state3:
        if (num.charAt(i) == '+' | num.charAt(i) == '-' ) {
          if ((int) num.charAt(i+1)>= 48 && (int) num.charAt(i+1) <=57) {
            current = FloatingState.state4;
          }
        } else if ((int) num.charAt(i)>= 48 && (int) num.charAt(i) <=57) {
          current = FloatingState.state4;
        } else return false; 
         break;
      case state4:
       if ((int) num.charAt(i)>= 48 && (int) num.charAt(i) <=57) {
         current = FloatingState.state5;
       } else return false;
        break;
         
      case state5: //checked
      if (num.charAt(i) == '_') {
         if (!((int) num.charAt(i+1)>= 48 && (int) num.charAt(i+1) <=57)) {
           return false;
         }
      } else
       if ((int) num.charAt(i)>= 48 && (int) num.charAt(i) <=57) {
         current = FloatingState.state5;
       } else return false;
         //break;
      case state6:
      return true;
        // break;
      case state7:
         if ((int) num.charAt(i)>= 48 && (int) num.charAt(i) <=57) {
           current = FloatingState.state8;
         } else return false;
         break;
      case state8:
      if ((int) num.charAt(i)>= 48 && (int) num.charAt(i) <=57) {
           current = FloatingState.state8;
         } else if (num.charAt(i) == 'E' | num.charAt(i) == 'e') {
           current = FloatingState.state3;
         } else return false;
        break; 
      case state9:
      if (num.charAt(i) == '.') {
        current = FloatingState.state2;
      } else
      if ((int) num.charAt(i)>= 48 && (int) num.charAt(i) <=57) {
        current = FloatingState.state0;
      } else if (num.charAt(i) == 'X' | num.charAt(i) == 'x') {
        current = FloatingState.state10;
      } else return false;
         break;
  
      case state10:
      if (num.charAt(i) == '_') {
        if (((int) num.charAt(i+1)>= 48 && (int) num.charAt(i+1) <=57 || (int) num.charAt(i+1)>= 65 && (int) num.charAt(i+1) <=70)) {
          current = FloatingState.state12;;
        }
      } else
        if ((int) num.charAt(i)>= 48 && (int) num.charAt(i) <=57 || (int) num.charAt(i)>= 65 && (int) num.charAt(i) <=70) {
          current = FloatingState.state11;
        }
       else if (num.charAt(i) == '.') {
        current = FloatingState.state12;
      } else return false;
         break;
      case state11:
      if ((int) num.charAt(i)>= 48 && (int) num.charAt(i) <=57 || (int) num.charAt(i)>= 65 && (int) num.charAt(i) <=70) {
          current = FloatingState.state11;
      }
      if (num.charAt(i) == '.') {
        current = FloatingState.state14;
      } else if (num.charAt(i) == 'P' | num.charAt(i) == 'p') {
        current = FloatingState.state13;
      } else return false;
        break; 
      case state12: //mantisa
      
      if ((int) num.charAt(i)>= 48 && (int) num.charAt(i) <=57 || (int) num.charAt(i)>= 65 && (int) num.charAt(i) <=70) {
          current = FloatingState.state12;
        } else if (num.charAt(i) == 'P' | num.charAt(i) == 'p') {
          if (!((int) num.charAt(i-1)>= 48 && (int) num.charAt(i-1) <=57 || (int) num.charAt(i-1)>= 65 && (int) num.charAt(i-1) <=70)) {
              return false;
          }
        current = FloatingState.state13;
      } else return false;
         break;
      case state13:
        if (num.charAt(i) == '+' | num.charAt(i) == '-' ) {
          if ((int) num.charAt(i+1)>= 48 && (int) num.charAt(i+1) <=57) {
            current = FloatingState.state15;
          }
        } else if ((int) num.charAt(i)>= 48 && (int) num.charAt(i) <=57) {
          current = FloatingState.state15;
        } else return false;
         break;
      case state14:
      
      if ((int) num.charAt(i)>= 48 && (int) num.charAt(i) <=57 || (int) num.charAt(i)>= 65 && (int) num.charAt(i) <=70) {
          current = FloatingState.state14;
        } else if (num.charAt(i) == 'P' | num.charAt(i) == 'p') {
        current = FloatingState.state13;
      } else return false;
        break; 
      case state15:
      if (num.charAt(i) == '_') {
        if (!((int) num.charAt(i+1)>= 48 && (int) num.charAt(i+1) <=57 || (int) num.charAt(i+1)>= 65 && (int) num.charAt(i+1) <=70)) {
          return false;
        }
      } else
      if ((int) num.charAt(i)>= 48 && (int) num.charAt(i) <=57) {
        current = FloatingState.state15;
      } //else  System.out.println("Error in state 15");
      else return false;
      break;
      
      }
    }
    return true;
  }
  enum FloatingState{
    state0, state1, state2, state3, state4, state5, state6, state7, state8,state9, state10, state11, state12, state13, state14, state15;
  }
  }
  