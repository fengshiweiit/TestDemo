package thread;

import java.util.Comparator;

public class TreeDomain implements Comparable<TreeDomain>{

    public TreeDomain(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Override
//    public int comparet(TreeDomain o1, TreeDomain o2) {
//
//        return o1.getId().compareTo(o2.getId());
////        long l = o1.getId() - o2.getId();
////        if (l >= 0) {
////            return 1;
////        }
////        return -1;
//    }

    @Override
    public int compareTo(TreeDomain o) {
        long result = this.getId() - o.getId();
        if (result > 0) {
            return -1;
        }
        return 1;
    }
}
