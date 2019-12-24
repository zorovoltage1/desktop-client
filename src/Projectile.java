public final class Projectile extends Renderable {

    int id;
    int floor;
    int x1;
    int y1;
    int height;
    int endHeight;
    int startMovementCycle;
    int endCycle;
    int slope;
    int startHeight;
    int interacting;
    boolean isMoving;
    double x;
    double y;
    double z;
    double velocityX;
    double velocityY;
    double scalar;
    double velocityZ;
    double heightOffset;
    int rotationX;
    int rotationY;
    Sequence animationSequence;
    int int7;
    int int6;

    Projectile(final int id, final int int_1, final int int_2, final int int_3, final int int_4, final int int_5, final int int_6, final int int_7, final int int_8, final int int_9, final int int_10) {
        isMoving = false;
        int7 = 0;
        int6 = 0;
        this.id = id;
        floor = int_1;
        x1 = int_2;
        y1 = int_3;
        height = int_4;
        startMovementCycle = int_5;
        endCycle = int_6;
        slope = int_7;
        startHeight = int_8;
        interacting = int_9;
        endHeight = int_10;
        isMoving = false;
        final int int_11 = MouseRecorder.getSpotAnimType(this.id).animationId;
        if (int_11 != -1) {
            animationSequence = TotalQuantityComparator.getAnimation(int_11);
        } else {
            animationSequence = null;
        }

    }

    void moveProjectile(final int int_0, final int int_1, final int int_2, final int int_3) {
        double double_0;
        if (!isMoving) {
            double_0 = int_0 - x1;
            final double double_1 = int_1 - y1;
            final double double_2 = Math.sqrt((double_1 * double_1) + (double_0 * double_0));
            x = x1 + ((startHeight * double_0) / double_2);
            y = ((startHeight * double_1) / double_2) + y1;
            z = height;
        }

        double_0 = (endCycle + 1) - int_3;
        velocityX = (int_0 - x) / double_0;
        velocityY = (int_1 - y) / double_0;
        scalar = Math.sqrt((velocityX * velocityX) + (velocityY * velocityY));
        if (!isMoving) {
            velocityZ = -scalar * Math.tan(0.02454369D * slope);
        }

        heightOffset = ((int_2 - z - (double_0 * velocityZ)) * 2.0D) / (double_0 * double_0);
    }

    void update(final int int_0) {
        isMoving = true;
        x += velocityX * int_0;
        y += velocityY * int_0;
        z += (int_0 * 0.5D * heightOffset * int_0) + (int_0 * velocityZ);
        velocityZ += heightOffset * int_0;
        rotationX = ((int) (Math.atan2(velocityX, velocityY) * 325.949D) + 1024) & 0x7FF;
        rotationY = (int) (Math.atan2(velocityZ, scalar) * 325.949D) & 0x7FF;
        if (animationSequence != null) {
            int6 += int_0;

            while (true) {
                do {
                    do {
                        if (int6 <= animationSequence.frameLengths[int7]) {
                            return;
                        }

                        int6 -= animationSequence.frameLengths[int7];
                        ++int7;
                    }
                    while (int7 < animationSequence.frameIDs.length);

                    int7 -= animationSequence.frameStep;
                }
                while ((int7 >= 0) && (int7 < animationSequence.frameIDs.length));

                int7 = 0;
            }
        }
    }

    @Override
    protected Model getModel() {
        final Spotanim spotanim_0 = MouseRecorder.getSpotAnimType(id);
        final Model model_0 = spotanim_0.getModel(int7);
        if (model_0 == null) {
            return null;
        } else {
            model_0.rotateZ(rotationY);
            return model_0;
        }
    }

}
