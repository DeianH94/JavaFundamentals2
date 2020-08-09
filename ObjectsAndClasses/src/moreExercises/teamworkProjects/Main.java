package moreExercises.teamworkProjects;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Team> teams = new ArrayList<>();

        int numOfTeams = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numOfTeams; i++) {
            String[] teamParams = scanner.nextLine().split("-");
            String creatorName = teamParams[0];
            String teamName = teamParams[1];
            boolean canCreateTeam = true;
            for (Team team : teams) {
                if (team.getName().equals(teamName)) {
                    System.out.println("Team " + teamName + " was already created!");
                    canCreateTeam = false;
                    break;
                }

                if (team.getCreator().getName().equals(creatorName)) {
                    System.out.println(creatorName + " cannot create another team!");
                    canCreateTeam = false;
                    break;
                }
            }

            if (canCreateTeam) {
                User user = new User(creatorName);
                Team team = new Team(teamName, user);
                teams.add(team);
                System.out.printf("Team %s has been created by %s!%n", teamName, creatorName);
            }
        }

        String userToAdd = scanner.nextLine();

        while (!userToAdd.equalsIgnoreCase("end of assignment")) {
            String[] userParams = userToAdd.split("->");
            String userName = userParams[0];
            String teamName = userParams[1];
            boolean teamDoesNotExists = true;
            for (Team team : teams) {
                if (team.getName().equals(teamName)) {
                    teamDoesNotExists = false;
                    break;
                }
            }

            if (teamDoesNotExists) {
                System.out.println("Team " + teamName + " does not exist!");
            }

            boolean memberIsInTeam = false;
            for (Team team : teams) {
                if (team.getCreator().getName().equals(userName)) {
                    memberIsInTeam = true;
                    break;
                }

                for (int i = 0; i < team.getMembers().size(); i++) {
                    if (team.getMembers().get(i).getName().equals(userName)) {
                        memberIsInTeam = true;
                        break;
                    }
                }
            }

            if (memberIsInTeam && !teamDoesNotExists) {
                System.out.println("Member " + userName + " cannot join team "  + teamName + "!");
            }

            if (!teamDoesNotExists && !memberIsInTeam) {
                User user = new User(userName);
                for (Team team : teams) {
                    if (team.getName().equals(teamName)) {
                        team.addMember(user);
                    }
                }
            }

            userToAdd = scanner.nextLine();
        }

        teams.forEach(Team::sortMembers);
        teams.stream()
                .filter(t -> t.memberSize() > 0)
                .sorted(Comparator.comparing(Team::getName))
                .sorted(Comparator.comparing(Team::memberSize).reversed())
                .forEach(System.out::println);

        System.out.println("Teams to disband:");
        teams.stream()
                .filter(t -> t.memberSize() == 0)
                .sorted(Comparator.comparing(Team::getName))
                .forEach(t -> System.out.println(t.getName()));
    }
}
