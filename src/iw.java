public class iw extends gc {
    protected iw(int paramInt1, int paramInt2) {
        super(paramInt1, paramInt2, jy.n);
    }

    @Override
    public dw d(eq parameq, int paramInt1, int paramInt2, int paramInt3) {
        return null;
    }

    @Override
    public boolean a() {
        return false;
    }

    @Override
    public boolean a(eq parameq, int paramInt1, int paramInt2, int paramInt3) {
        if (parameq.d(paramInt1 - 1, paramInt2, paramInt3)) {
            return true;
        }
        if (parameq.d(paramInt1 + 1, paramInt2, paramInt3)) {
            return true;
        }
        if (parameq.d(paramInt1, paramInt2, paramInt3 - 1)) {
            return true;
        }
        if (parameq.d(paramInt1, paramInt2, paramInt3 + 1)) {
            return true;
        }
        return parameq.d(paramInt1, paramInt2 - 1, paramInt3);
    }

    @Override
    public void c(eq parameq, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        int i = parameq.b(paramInt1, paramInt2, paramInt3);

        int j = i & 0x8;
        i &= 7;

        if ((paramInt4 == 1) && (parameq.d(paramInt1, paramInt2 - 1, paramInt3))) {
            i = 5 + parameq.l.nextInt(2);
        }
        if ((paramInt4 == 2) && (parameq.d(paramInt1, paramInt2, paramInt3 + 1))) {
            i = 4;
        }
        if ((paramInt4 == 3) && (parameq.d(paramInt1, paramInt2, paramInt3 - 1))) {
            i = 3;
        }
        if ((paramInt4 == 4) && (parameq.d(paramInt1 + 1, paramInt2, paramInt3))) {
            i = 2;
        }
        if ((paramInt4 == 5) && (parameq.d(paramInt1 - 1, paramInt2, paramInt3))) {
            i = 1;
        }

        parameq.b(paramInt1, paramInt2, paramInt3, i + j);
    }

    @Override
    public void e(eq parameq, int paramInt1, int paramInt2, int paramInt3) {
        if (parameq.d(paramInt1 - 1, paramInt2, paramInt3)) {
            parameq.b(paramInt1, paramInt2, paramInt3, 1);
        } else if (parameq.d(paramInt1 + 1, paramInt2, paramInt3)) {
            parameq.b(paramInt1, paramInt2, paramInt3, 2);
        } else if (parameq.d(paramInt1, paramInt2, paramInt3 - 1)) {
            parameq.b(paramInt1, paramInt2, paramInt3, 3);
        } else if (parameq.d(paramInt1, paramInt2, paramInt3 + 1)) {
            parameq.b(paramInt1, paramInt2, paramInt3, 4);
        } else if (parameq.d(paramInt1, paramInt2 - 1, paramInt3)) {
            parameq.b(paramInt1, paramInt2, paramInt3, 5 + parameq.l.nextInt(2));
        }
        g(parameq, paramInt1, paramInt2, paramInt3);
    }

    @Override
    public void b(eq parameq, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if (g(parameq, paramInt1, paramInt2, paramInt3)) {
            int i = parameq.b(paramInt1, paramInt2, paramInt3) & 0x7;
            int j = 0;

            if ((!parameq.d(paramInt1 - 1, paramInt2, paramInt3)) && (i == 1)) {
                j = 1;
            }
            if ((!parameq.d(paramInt1 + 1, paramInt2, paramInt3)) && (i == 2)) {
                j = 1;
            }
            if ((!parameq.d(paramInt1, paramInt2, paramInt3 - 1)) && (i == 3)) {
                j = 1;
            }
            if ((!parameq.d(paramInt1, paramInt2, paramInt3 + 1)) && (i == 4)) {
                j = 1;
            }
            if ((!parameq.d(paramInt1, paramInt2 - 1, paramInt3)) && (i == 5)) {
                j = 1;
            }

            if (j != 0) {
                a_(parameq, paramInt1, paramInt2, paramInt3, parameq.b(paramInt1, paramInt2, paramInt3));
                parameq.d(paramInt1, paramInt2, paramInt3, 0);
            }
        }
    }

    private boolean g(eq parameq, int paramInt1, int paramInt2, int paramInt3) {
        if (!a(parameq, paramInt1, paramInt2, paramInt3)) {
            a_(parameq, paramInt1, paramInt2, paramInt3, parameq.b(paramInt1, paramInt2, paramInt3));
            parameq.d(paramInt1, paramInt2, paramInt3, 0);
            return false;
        }
        return true;
    }

    @Override
    public void a(iv paramiv, int paramInt1, int paramInt2, int paramInt3) {
        int i = paramiv.b(paramInt1, paramInt2, paramInt3) & 0x7;
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

    @Override
    public void b(eq parameq, int paramInt1, int paramInt2, int paramInt3, fz paramfz) {
        a(parameq, paramInt1, paramInt2, paramInt3, paramfz);
    }

    @Override
    public boolean a(eq parameq, int paramInt1, int paramInt2, int paramInt3, fz paramfz) {
        if (parameq.z) {
            return true;
        }
        int i = parameq.b(paramInt1, paramInt2, paramInt3);
        int j = i & 0x7;
        int k = 8 - (i & 0x8);

        // hMod: Allow the lever to change the current
        int old = (k != 8) ? 1 : 0;
        int current = (k == 8) ? 1 : 0;
        current = (Integer) etc.getLoader().callHook(PluginLoader.Hook.REDSTONE_CHANGE, new Block(this.bh, paramInt1, paramInt2, paramInt3), old, current);

        if ((current > 0) == (k == 8)) {
            parameq.b(paramInt1, paramInt2, paramInt3, j + k);
            parameq.b(paramInt1, paramInt2, paramInt3, paramInt1, paramInt2, paramInt3);

            parameq.a(paramInt1 + 0.5D, paramInt2 + 0.5D, paramInt3 + 0.5D, "random.click", 0.3F, k > 0 ? 0.6F : 0.5F);

            parameq.g(paramInt1, paramInt2, paramInt3, this.bh);
            if (j == 1) {
                parameq.g(paramInt1 - 1, paramInt2, paramInt3, this.bh);
            } else if (j == 2) {
                parameq.g(paramInt1 + 1, paramInt2, paramInt3, this.bh);
            } else if (j == 3) {
                parameq.g(paramInt1, paramInt2, paramInt3 - 1, this.bh);
            } else if (j == 4) {
                parameq.g(paramInt1, paramInt2, paramInt3 + 1, this.bh);
            } else {
                parameq.g(paramInt1, paramInt2 - 1, paramInt3, this.bh);
            }
        }

        return true;
    }

    @Override
    public void b(eq parameq, int paramInt1, int paramInt2, int paramInt3) {
        int i = parameq.b(paramInt1, paramInt2, paramInt3);
        if ((i & 0x8) > 0) {
            parameq.g(paramInt1, paramInt2, paramInt3, this.bh);
            int j = i & 0x7;
            if (j == 1) {
                parameq.g(paramInt1 - 1, paramInt2, paramInt3, this.bh);
            } else if (j == 2) {
                parameq.g(paramInt1 + 1, paramInt2, paramInt3, this.bh);
            } else if (j == 3) {
                parameq.g(paramInt1, paramInt2, paramInt3 - 1, this.bh);
            } else if (j == 4) {
                parameq.g(paramInt1, paramInt2, paramInt3 + 1, this.bh);
            } else {
                parameq.g(paramInt1, paramInt2 - 1, paramInt3, this.bh);
            }
        }
        super.b(parameq, paramInt1, paramInt2, paramInt3);
    }

    @Override
    public boolean b(iv paramiv, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        return (paramiv.b(paramInt1, paramInt2, paramInt3) & 0x8) > 0;
    }

    @Override
    public boolean d(eq parameq, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        int i = parameq.b(paramInt1, paramInt2, paramInt3);
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

    @Override
    public boolean c() {
        return true;
    }
}
