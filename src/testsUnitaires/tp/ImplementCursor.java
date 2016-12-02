package testsUnitaires.tp;

public class ImplementCursor implements InterfaceCursor
{
	private InterfacePoint position, direction;

	public ImplementCursor(InterfacePoint position, InterfacePoint direction)
	{
		setPosition(position);
		setDirection(direction);
	}

	public void setDirection(InterfacePoint direction)
	{
		this.direction = direction;
	}

	public void setPosition(InterfacePoint position)
	{
		this.position = position;
	}

	public ImplementCursor()
	{
		reset();
	}

	@Override
	public InterfacePoint getPosition()
	{
		return position;
	}

	@Override
	public InterfacePoint getDirection()
	{
		return direction;
	}

	@Override
	public void reset()
	{
		setPosition(new ImplementPoint(0, 0));
		setDirection(new ImplementPoint(1, 0));
	}

	@Override
	public void stepStraigth()
	{
		setPosition(getPosition().add(getDirection()));
	}

	@Override
	public void turnRight()
	{
		setDirection(new ImplementPoint(getDirection().getOrd(),
				-getDirection().getAbs()));
	}

	@Override
	public void turnLeft()
	{
		setDirection(new ImplementPoint(-getDirection().getOrd(),
				getDirection().getAbs()));
	}
}
