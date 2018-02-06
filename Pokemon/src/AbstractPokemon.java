
public abstract class AbstractPokemon implements PokemonInterface{
    public Pokemon createPokemon(String name,int health,String type){// Whats the point if we dont return the pokemon? Cant do anything if we don't, unless we stick them all in an arraylist with a getter to lookup a pokemon by name.
        return new Pokemon(name,health,type);
    }

    public void attackPokemon(Pokemon pokemon){
        pokemon.setHealth(pokemon.getHealth()-10);
    }
}