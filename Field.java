import java.util.LinkedList;
public class Field {
    public static void main(String[] args) {
        field f=new field();
        String a =new String("4323");
        if (f.possibleInsert(boat.buildBoat(a)))
            f.add_boat(new boat("4323"));
        System.out.println(f);
        if (f.possibleInsert(boat.buildBoat(a)))
            f.add_boat(new boat("4323"));
        System.out.println(f);
        int i=-1;
        String[] s={
            "2 3", 
            "2 4", 
            "3 4", 
            "1 2",
            "0 0"}; 
        do{
            
            
            i++;
        }while(f.check_game(s[i]));
        System.out.println(f);
    }
}
class field
{
    private LinkedList<boat> map;

    field()
    {
        this.map=new LinkedList<boat>();
    }

    public boolean possibleInsert(int[][] crd)
    {
        String[] coor = new String[2];
        for(int[] cord: crd){
            String[] coord= new String[2];
            coor[0]=String.valueOf(cord[0]);
            coor[1]=String.valueOf(cord[1]);
            if(check_boat(coor)!=null){
                System.out.println("Error 02: collision issues");
                return false;
            }
        }
        return true;
    }

    public void add_boat(boat babour)
    {
        if (this.map.size()<6 )
            this.map.add(babour);
        else 
               System.out.println("Error 01: number of boats out passed!");
    }

    public boat check_boat(String[] coor)
    {
        /* verifie si la coordonée en parametre est celle d'un bateau if it's the case elle retourne vrais sinon Faux */

        for (boat babour:map) {
            if (babour.have_coor(coor))
                    return babour;
            
        }
        return null;
    }
    @Override
    public String toString() {
            String s=new String();
            for (boat var : map) {
                s+=var.toString();                
            }
            return s;
        }
    public boolean check_game(String s)
    {
        String[] coor = s.strip().split(" ");
        boat babour =check_boat(coor);
        if(map.size()<=0 || babour == null )
                return false;
            else
            {babour.removePart(s);System.out.println("ani nektlou terf!");};
        return true;
    }
    public void remove_boat(boat babour){
            this.map.remove(babour);
    }
    LinkedList<boat> getmap()
        {
            return map;
        }
}