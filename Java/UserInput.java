import java.lang.Character;

public class UserInput {
    public static class TextInput {
      StringBuilder value = new StringBuilder();
      
      public void add(char c){
        value.append(c);
      }
      
      public String getValue(){
        return value.toString();
      }
      
    }

    public static class NumericInput extends TextInput {
      @Override
      public void add(char c){
        if(!Character.isLetter(c)){
          value.append(c);
        }
      }
    }

    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}
