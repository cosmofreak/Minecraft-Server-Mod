
import java.util.Random;

public class OBlockLever extends OBlock {

    protected OBlockLever(int paramInt1, int paramInt2) {
        super(paramInt1, paramInt2, OMaterial.n);
    }

    public OAxisAlignedBB d(OWorld paramOWorld, int paramInt1, int paramInt2, int paramInt3) {
        return null;
    }

    public boolean a() {
        return false;
    }

    public boolean a(OWorld paramOWorld, int paramInt1, int paramInt2, int paramInt3) {
        if (paramOWorld.d(paramInt1 - 1, paramInt2, paramInt3)) {
            return true;
        }
        if (paramOWorld.d(paramInt1 + 1, paramInt2, paramInt3)) {
            return true;
        }
        if (paramOWorld.d(paramInt1, paramInt2, paramInt3 - 1)) {
            return true;
        }
        if (paramOWorld.d(paramInt1, paramInt2, paramInt3 + 1)) {
            return true;
        }
        return paramOWorld.d(paramInt1, paramInt2 - 1, paramInt3);
    }

    public void c(OWorld paramOWorld, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        int i = paramOWorld.b(paramInt1, paramInt2, paramInt3);

        int j = i & 0x8;
        i &= 7;

        if ((paramInt4 == 1) && (paramOWorld.d(paramInt1, paramInt2 - 1, paramInt3))) {
            i = 5 + paramOWorld.l.nextInt(2);
        }
        if ((paramInt4 == 2) && (paramOWorld.d(paramInt1, paramInt2, paramInt3 + 1))) {
            i = 4;
        }
        if ((paramInt4 == 3) && (paramOWorld.d(paramInt1, paramInt2, paramInt3 - 1))) {
            i = 3;
        }
        if ((paramInt4 == 4) && (paramOWorld.d(paramInt1 + 1, paramInt2, paramInt3))) {
            i = 2;
        }
        if ((paramInt4 == 5) && (paramOWorld.d(paramInt1 - 1, paramInt2, paramInt3))) {
            i = 1;
        }

        paramOWorld.c(paramInt1, paramInt2, paramInt3, i + j);
    }

    public void e(OWorld paramOWorld, int paramInt1, int paramInt2, int paramInt3) {
        if (paramOWorld.d(paramInt1 - 1, paramInt2, paramInt3)) {
            paramOWorld.c(paramInt1, paramInt2, paramInt3, 1);
        } else if (paramOWorld.d(paramInt1 + 1, paramInt2, paramInt3)) {
            paramOWorld.c(paramInt1, paramInt2, paramInt3, 2);
        } else if (paramOWorld.d(paramInt1, paramInt2, paramInt3 - 1)) {
            paramOWorld.c(paramInt1, paramInt2, paramInt3, 3);
        } else if (paramOWorld.d(paramInt1, paramInt2, paramInt3 + 1)) {
            paramOWorld.c(paramInt1, paramInt2, paramInt3, 4);
        } else if (paramOWorld.d(paramInt1, paramInt2 - 1, paramInt3)) {
            paramOWorld.c(paramInt1, paramInt2, paramInt3, 5 + paramOWorld.l.nextInt(2));
        }
        g(paramOWorld, paramInt1, paramInt2, paramInt3);
    }

    public void b(OWorld paramOWorld, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if (g(paramOWorld, paramInt1, paramInt2, paramInt3)) {
            int i = paramOWorld.b(paramInt1, paramInt2, paramInt3) & 0x7;
            int j = 0;

            if ((!paramOWorld.d(paramInt1 - 1, paramInt2, paramInt3)) && (i == 1)) {
                j = 1;
            }
            if ((!paramOWorld.d(paramInt1 + 1, paramInt2, paramInt3)) && (i == 2)) {
                j = 1;
            }
            if ((!paramOWorld.d(paramInt1, paramInt2, paramInt3 - 1)) && (i == 3)) {
                j = 1;
            }
            if ((!paramOWorld.d(paramInt1, paramInt2, paramInt3 + 1)) && (i == 4)) {
                j = 1;
            }
            if ((!paramOWorld.d(paramInt1, paramInt2 - 1, paramInt3)) && (i == 5)) {
                j = 1;
            }

            if (j != 0) {
                a_(paramOWorld, paramInt1, paramInt2, paramInt3, paramOWorld.b(paramInt1, paramInt2, paramInt3));
                paramOWorld.e(paramInt1, paramInt2, paramInt3, 0);
            }
        }
    }

    private boolean g(OWorld paramOWorld, int paramInt1, int paramInt2, int paramInt3) {
        if (!a(paramOWorld, paramInt1, paramInt2, paramInt3)) {
            a_(paramOWorld, paramInt1, paramInt2, paramInt3, paramOWorld.b(paramInt1, paramInt2, paramInt3));
            paramOWorld.e(paramInt1, paramInt2, paramInt3, 0);
            return false;
        }
        return true;
    }

    public void a(OIBlockAccess paramOIBlockAccess, int paramInt1, int paramInt2, int paramInt3) {
        int i = paramOIBlockAccess.b(paramInt1, paramInt2, paramInt3) & 0x7;
        float f = 0.1875F;
        if (i == 1) {
            a(0.0F, 0.2F, 0.5F - f, f * 2.0F, 0.8F, 0.5F + f);
        } else if (i == 2) {
            a(1.0F - f * 2.0F, 0.2F, 0.5F - f, 1.0F, 0.8F, 0.5F + f);
        } else if (i == 3) {
            a(0.5F - f, 0.2F, 0.0F, 0.5F + f, 0.8F, f * 2.0F);
        } else if (i == 4) {
            a(0.5F - f, 0.2F, 1.0F - f * 2.0F, 0.5F + f, 0.8F, 1.0F);
        } else {
            f = 0.25F;
            a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.6F, 0.5F + f);
        }
    }

    public void b(OWorld paramOWorld, int paramInt1, int paramInt2, int paramInt3, OEntityPlayer paramOEntityPlayer) {
        a(paramOWorld, paramInt1, paramInt2, paramInt3, paramOEntityPlayer);
    }

    public boolean a(OWorld paramOWorld, int paramInt1, int paramInt2, int paramInt3, OEntityPlayer paramOEntityPlayer) {
        if (paramOWorld.z) {
            return true;
        }
        int i = paramOWorld.b(paramInt1, paramInt2, paramInt3);
        int j = i & 0x7;
        int k = 8 - (i & 0x8);

        // hMod: Allow the lever to change the current
        int old = (k != 8) ? 1 : 0;
        int current = (k == 8) ? 1 : 0;
        current = (Integer) etc.getLoader().callHook(PluginLoader.Hook.REDSTONE_CHANGE, new Block(this.bi, paramInt1, paramInt2, paramInt3), old, current);

        if ((current > 0) == (k == 8)) {
            paramOWorld.c(paramInt1, paramInt2, paramInt3, j + k);
            paramOWorld.b(paramInt1, paramInt2, paramInt3, paramInt1, paramInt2, paramInt3);

            paramOWorld.a(paramInt1 + 0.5D, paramInt2 + 0.5D, paramInt3 + 0.5D, "random.click", 0.3F, k > 0 ? 0.6F : 0.5F);

            paramOWorld.h(paramInt1, paramInt2, paramInt3, bi);
            if (j == 1) {
                paramOWorld.h(paramInt1 - 1, paramInt2, paramInt3, bi);
            } else if (j == 2) {
                paramOWorld.h(paramInt1 + 1, paramInt2, paramInt3, bi);
            } else if (j == 3) {
                paramOWorld.h(paramInt1, paramInt2, paramInt3 - 1, bi);
            } else if (j == 4) {
                paramOWorld.h(paramInt1, paramInt2, paramInt3 + 1, bi);
            } else {
                paramOWorld.h(paramInt1, paramInt2 - 1, paramInt3, bi);
            }
        }
        return true;
    }

    public void b(OWorld paramOWorld, int paramInt1, int paramInt2, int paramInt3) {
        int i = paramOWorld.b(paramInt1, paramInt2, paramInt3);
        if ((i & 0x8) > 0) {
            paramOWorld.h(paramInt1, paramInt2, paramInt3, bi);
            int j = i & 0x7;
            if (j == 1) {
                paramOWorld.h(paramInt1 - 1, paramInt2, paramInt3, bi);
            } else if (j == 2) {
                paramOWorld.h(paramInt1 + 1, paramInt2, paramInt3, bi);
            } else if (j == 3) {
                paramOWorld.h(paramInt1, paramInt2, paramInt3 - 1, bi);
            } else if (j == 4) {
                paramOWorld.h(paramInt1, paramInt2, paramInt3 + 1, bi);
            } else {
                paramOWorld.h(paramInt1, paramInt2 - 1, paramInt3, bi);
            }
        }
        super.b(paramOWorld, paramInt1, paramInt2, paramInt3);
    }

    public boolean b(OIBlockAccess paramOIBlockAccess, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        return (paramOIBlockAccess.b(paramInt1, paramInt2, paramInt3) & 0x8) > 0;
    }

    public boolean d(OWorld paramOWorld, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        int i = paramOWorld.b(paramInt1, paramInt2, paramInt3);
        if ((i & 0x8) == 0) {
            return false;
        }
        int j = i & 0x7;

        if ((j == 5) && (paramInt4 == 1)) {
            return true;
        }
        if ((j == 4) && (paramInt4 == 2)) {
            return true;
        }
        if ((j == 3) && (paramInt4 == 3)) {
            return true;
        }
        if ((j == 2) && (paramInt4 == 4)) {
            return true;
        }
        return (j == 1) && (paramInt4 == 5);
    }

    public boolean c() {
        return true;
    }
}