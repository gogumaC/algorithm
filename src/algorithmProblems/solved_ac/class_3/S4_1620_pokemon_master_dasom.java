package solved.ac.class_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class S4_1620_pokemon_master_dasom {

    static public void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder=new StringBuilder();

        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]);
        int m=Integer.parseInt(input[1]);

        String[] pokemons=new String[n+1];
        Map<String,Integer> stringMap= new HashMap<>();
        for(int i=1;i<=n;i++){
            String pokemon=br.readLine();
            pokemons[i]=pokemon;
            stringMap.put(pokemon,i);
        }

        for(int i=0;i<m;i++){
            String query=br.readLine();
            if(query.matches("\\d*")){
                builder.append(pokemons[Integer.parseInt(query)]);
            }else{
                builder.append(stringMap.get(query));
            }
            builder.append("\n");
        }

        System.out.println(builder);

    }
}
