package net.KanasakiTechnologics.CreateTempad.fluid;


import net.neoforged.neoforge.fluids.BaseFlowingFluid;

public abstract class ShimmerFluid {
    public static class Source extends BaseFlowingFluid.Source {
        public Source(Properties props) {
            super(props);
        }
    }

    public static class Flowing extends BaseFlowingFluid.Flowing {
        public Flowing(Properties props) {
            super(props);
        }
    }

}
