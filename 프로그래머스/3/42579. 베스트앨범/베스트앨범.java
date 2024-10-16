import java.util.*;
import java.util.stream.Collectors;

class Solution {

    private static class Genre implements Comparable<Genre> {
        private String name;
        private List<Song> songs;
        private int play;

        public Genre(String name){
            this.name = name;
            songs = new ArrayList<>();
        }

        public boolean addSong(Song song){
            this.play += song.play;
            return songs.add(song);
        }

        @Override
        public int compareTo(Genre o) {
            return play - o.play;
        }
    }
    private static class Song implements Comparable<Song>{
        private int id;
        private int play;

        public Song(int id, int play){
            this.id = id;
            this.play = play;
        }

        @Override
        public int compareTo(Song o) {
            return (play == o.play) ? id - o.id : o.play - play;
        }
    }
    public int[] solution(String[] genres, int[] plays) {

        Map<String, Genre> play_map = new HashMap<>();
        Genre temp;

        for(int i = 0 ; i < genres.length ; i++){
            if(!play_map.containsKey(genres[i])) play_map.put(genres[i], new Genre(genres[i]));

            temp = play_map.get(genres[i]);
            temp.addSong(new Song(i,plays[i]));
        }

        List<Genre> sorted_genre =
                play_map.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Song> sorted_song;

        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i < play_map.size() ; i++){
            System.out.println(sorted_genre.get(i).name);
            sorted_song = sorted_genre.get(i).songs;
            sorted_song.sort(Comparator.naturalOrder());

            for(int j = 0 ; j < sorted_song.size() ; j++){
                if(j == 2) break;
                res.add(sorted_song.get(j).id);
            }
        }

        int[] answer = new int[res.size()];
        for(int i = 0 ; i < res.size() ; i++){
            answer[i] = res.get(i);
        }
        return answer;
    }
}