package naval;
import java.util.LinkedList;

class Field
{
    private List<Boat> map;

    Field()
    {
        this.map=new LinkedList<Boat>();
    }
    private boolean possibleInsert(String s)
    {
        String[] coor = s.strip().split(" ");
        if(check_boat(coor)!=null)
                return false;
        return true;
    }
    public void add_boat(Boat babour)
    {
        if (this.map.length()<6)
            if (!possibleInsert(babour))
                Systeme.out.println("Error 02: boundaries issues");
            else
                this.map.add(babour);
        else 
               Systeme.out.println("Error 01: number of boats out passed!");
    }
    public Boat check_boat(String[] coor)
    {
        /* verifie si la coordonée en parametre est celle d'un bateau if it's the case elle retourne vrais sinon Faux */

        for (Boat babour:map) {
            if (babour.have_coord(coor))
                    return babour;
            return null;
        }
    }

    public boolean check_game(String s)
    {
        String[] coor = s.strip().split(" ");
        if(map.size()<=0 || check_boat(coor) == null )
                return false;
            else
                check_boat(coor).remove_parts(coor);
    }
    public void remove_boat(Boat babour){
            this.map.remove(babour);
    }
    Boat getmap()
        {
            return map;
        }
}