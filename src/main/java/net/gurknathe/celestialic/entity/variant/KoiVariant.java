package net.gurknathe.celestialic.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum KoiVariant {
    DEFAULT(0),
    TANCHO(1),
    KOHAKU(2),
    SANKE(3),
    SHOWA(4),
    UTSURIMONO_RED(5),
    UTSURIMONO_WHITE(6),
    CHAGOI(7);

    private static final KoiVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(KoiVariant::getId)).toArray(KoiVariant[]::new);
    private final int id;

    KoiVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static KoiVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
