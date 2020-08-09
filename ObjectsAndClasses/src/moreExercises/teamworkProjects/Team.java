package moreExercises.teamworkProjects;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Team {
    private String name;
    private User creator;
    private List<User> members;

    public Team(String name, User creator) {
        this.setName(name);
        this.setCreator(creator);
        this.members = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getCreator() {
        return this.creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<User> getMembers() {
        return this.members;
    }

    public void addMember(User user) {
        this.members.add(user);
    }

    public void sortMembers() {
        this.getMembers().sort(Comparator.comparing(User::getName));
    }

    public int memberSize() {
        return this.getMembers().size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(this.getName());
        builder.append(System.lineSeparator())
                .append("- ")
                .append(this.getCreator().getName())
                .append(System.lineSeparator());

        for (int i = 0; i < this.getMembers().size() - 1; i++) {
            builder.append("-- ")
                    .append(this.getMembers().get(i).getName())
                    .append(System.lineSeparator());
        }

        builder.append("-- ").append(this.getMembers().get(this.getMembers().size() - 1).getName());

        return builder.toString();
    }
}
