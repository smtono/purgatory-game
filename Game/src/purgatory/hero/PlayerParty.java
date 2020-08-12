package purgatory.hero;

import purgatory.entity.Entity;

import java.util.List;

public class PlayerParty {
    private List<Entity> partyMembers;

    public List<Entity> getPartyMembers() {
        return partyMembers;
    }
    public void addPartyMember(Entity newMember){
        partyMembers.add(newMember);
    }
    public Entity removePartyMember(int indexOfMember) {
       return partyMembers.remove(indexOfMember);
    }
}
