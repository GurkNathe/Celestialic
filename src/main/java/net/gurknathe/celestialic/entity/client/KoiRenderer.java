package net.gurknathe.celestialic.entity.client;

import com.google.common.collect.Maps;
import net.gurknathe.celestialic.CelestialicMod;
import net.gurknathe.celestialic.entity.custom.KoiEntity;
import net.gurknathe.celestialic.entity.variant.KoiVariant;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import java.util.Map;

public class KoiRenderer extends GeoEntityRenderer<KoiEntity> {
    public static final Map<KoiVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(KoiVariant.class), (map) -> {
                map.put(KoiVariant.DEFAULT,
                        new Identifier(CelestialicMod.MOD_ID, "textures/entity/koi/koi_base.png"));
                map.put(KoiVariant.TANCHO,
                        new Identifier(CelestialicMod.MOD_ID, "textures/entity/koi/koi_tancho.png"));
                map.put(KoiVariant.DOITSU,
                        new Identifier(CelestialicMod.MOD_ID, "textures/entity/koi/koi_doitsu.png"));
                map.put(KoiVariant.GIN_RIN,
                        new Identifier(CelestialicMod.MOD_ID, "textures/entity/koi/koi_gin_rin.png"));
                map.put(KoiVariant.KOHAKU,
                        new Identifier(CelestialicMod.MOD_ID, "textures/entity/koi/koi_kohaku.png"));
                map.put(KoiVariant.SANKE,
                        new Identifier(CelestialicMod.MOD_ID, "textures/entity/koi/koi_sanke.png"));
                map.put(KoiVariant.UTSURIMONO_RED,
                        new Identifier(CelestialicMod.MOD_ID, "textures/entity/koi/koi_utsurimono_red.png"));
                map.put(KoiVariant.UTSURIMONO_WHITE,
                        new Identifier(CelestialicMod.MOD_ID, "textures/entity/koi/koi_utsurimono_white.png"));
                map.put(KoiVariant.KAWARIMONO_BROWN,
                        new Identifier(CelestialicMod.MOD_ID, "textures/entity/koi/koi_kawarimono_brown.png"));
            });

    public KoiRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new KoiModel());
    }

    @Override
    public Identifier getTextureLocation(KoiEntity instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant());
    }
}
