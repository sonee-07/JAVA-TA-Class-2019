import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class Tournament {

    private List<Team> teams;
    private int ranks[];                        //Why can't we declare this as final or static for that method?

    Tournament( List<Team> teams){

        this.teams = teams;
    }

    private static class Team{

        private String id;
        private int rank;                               //Private because we don't want anyone messing with the rank of our favourie team.
        Team(String arg_id, int arg_rank){
            id = arg_id;
            rank = arg_rank;
        }
    }

    Team startTournament(){

        List<Team> players = teams;
        int i=0;
        Team t1,t2;
        Team winner;
        int rank = teams.size();
        //keepappending the winners to the end so that round two occurs between them
        while(players.size()>1){
            t1 = players.remove(0);
            t2 = players.remove(0);
            winner =  playMatch(t1,t2);

            //set rank of the team who's going out
            if(winner.id==t1.id)
                t2.rank = rank;
            else t1.rank = rank;

            //wait-for-it we need to announce the winner
            System.out.println("Winner: "+winner.id+"\n");
            players.add(winner);

            //Simply because the rank goes down!
            rank--;

        }
        winner  = players.get(0);
        players.add(winner);
        return winner;
    }

        Team playMatch(Team team1, Team team2)
        {
            System.out.println("Match between: "+team1.id+" "+team2.id);
            Random rand = new Random();
            int winner = rand.nextInt(2)+1;

            return winner==1?team1:team2;
        }

        public static void main(String args[]){

          //
            List<Team> teams = new LinkedList<Team>();

            teams.add(new Team("France",5));
            teams.add(new Team("Croatia",3));
            teams.add(new Team("Belgium",2));
            teams.add(new Team("England",4));
            teams.add(new Team("Russia",1));
            Tournament t = new Tournament(teams);
            System.out.println();
            System.out.println("And it's coming home for: "+t.startTournament().id);

        }

}


