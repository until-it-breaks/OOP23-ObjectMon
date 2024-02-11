package it.unibo.objectmon.model.entities.api;

import java.util.UUID;

import it.unibo.objectmon.model.world.api.Coord;

/**
 * A basic implementation of a game entity.
 */
public abstract class AbstractEntity implements Entity {

    private final String name;
    private Coord position;
    private Direction facingDirection;
    private final UUID id;

    /**
     * Constructs a simple entity.
     * 
     * @param name the name of the entity.
     * @param coord the starting position of the entity.
     */
    public AbstractEntity(final String name, final Coord coord) {
        this.name = name;
        this.position = coord;
        this.facingDirection = Direction.DOWN;
        this.id = UUID.randomUUID();
    }

    @Override
    public final void setPosition(final Coord coord) {
        this.position = coord;
    }

    @Override
    public final Coord getPosition() {
        return this.position;
    }

    @Override
    public final String getName() {
        return this.name;
    }

    @Override
    public final Direction getDirection() {
        return facingDirection;
    }

    @Override
    public final void setDirection(final Direction facingDirection) {
        this.facingDirection = facingDirection;
    }

    /**
     * Retrieves the unique identifier of the NPC.
     * 
     * @return The {@link UUID}
     */
    public UUID getId() {
        return id;
    }

    /**
     * Computes a hash code for this NPC.
     * 
     * @return A hash code value for this NPC.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    /**
     * Indicates whether some other object is equal to this NPC.
     * The {@link UUID} is also used to make the comparison.
     * 
     * @param obj The reference object with which to compare.
     * @return {@code true} if this NPC is the same as the obj argument; {@code false} otherwise.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractEntity other = (AbstractEntity) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }
}
