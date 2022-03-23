package brickset;

import repository.Repository;

/**
 * Represents a repository of {@code LegoSet} objects.
 */
public class LegoSetRepository extends Repository<LegoSet> {

    public LegoSetRepository() {
        super(LegoSet.class, "brickset.json");
    }

    public long countLegoSetsWithTag(String tag) {
        return getAll().stream()
                .filter(legoSet -> legoSet.getTags() != null && legoSet.getTags().contains(tag))
                .count();
    }

    /**
     * Prints the LEGO Sets which contain at least 500 pieces.
     */
    public void printLegoSetsOver500Pieces() {
        getAll().stream()
                .filter(legoSet -> legoSet.getPieces() >= 500)
                .map(LegoSet::getName).distinct().forEach(System.out::println);
    }
    /**
     * Prints the LEGO Sets which are made for children.
     * Prints the name of LEGO Sets with theme "Duplo"
     */
    public void printLegoSetsForChildren() {
        getAll().stream()
                .filter(legoSet -> legoSet.getTheme().equals("Duplo"))
                .map(LegoSet::getName).distinct().forEach(System.out::println);
    }
    /**
     * Prints the Volume of each LEGO Set which have "dimensions" tag
     */
    public void countLegoSetsVolume() {
        getAll().stream()
                .filter(legoSet ->
                                legoSet.getDimensions() != null
                                && legoSet.getDimensions().getHeight() != null
                                && legoSet.getDimensions().getWidth() !=null
                                && legoSet.getDimensions().getDepth() !=null)
                .forEach(x -> System.out.println((int) (Math.floor(
                        x.getDimensions().getHeight()*
                        x.getDimensions().getWidth()*
                        x.getDimensions().getDepth()))+ "cm³"));
    }
    /**
     * Prints the LEGO Sets which have more than 10 tags
     */
    public long countLegoSetsOver10Tags() {
        return getAll().stream()
                .filter(legoSet -> legoSet.getTags() != null && legoSet.getTags().size() > 9).count();
    }

    /**
     * Prints the LEGO Sets with theme "Gear" and subtheme "Video Games/PC"
     */

    public void printLegoSetsWithThemeGearSubthemeVideoGames(){
        getAll().stream()
                .filter(legoSet -> legoSet.getTheme().equals("Gear") &&
                        legoSet.getSubtheme().equals("Video Games/PC"))
                        .distinct().map(LegoSet::getName)
                        .forEach(System.out::println);

    }

    public static void main(String[] args) {
        var repository = new LegoSetRepository();
        //System.out.println(repository.countLegoSetsWithTag("Microscale"));
        repository.printLegoSetsOver500Pieces();
        System.out.println("----------------------------");
        repository.printLegoSetsForChildren();
        System.out.println("----------------------------");
        repository.countLegoSetsVolume();
        System.out.println("----------------------------");
        System.out.println(repository.countLegoSetsOver10Tags());
        System.out.println("----------------------------");
        repository.printLegoSetsWithThemeGearSubthemeVideoGames();
        System.out.println("----------------------------");
    }
}

