package net.gurknathe.celestialic.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum KoiVariant {
    DEFAULT(0),
    TANCHO(1),
    DOITSU(2),
    GIN_RIN(3),
    KOHAKU(4),
    SANKE(5),
    SHOWA(6),

    UTSURIMONO_RED(7),
    UTSURIMONO_WHITE(8),
    KAWARIMONO_BROWN(9);

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
