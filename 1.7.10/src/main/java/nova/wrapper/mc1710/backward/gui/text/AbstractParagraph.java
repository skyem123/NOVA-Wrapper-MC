package nova.wrapper.mc1710.backward.gui.text;

import nova.core.gui.render.text.TextRenderer.RenderedText;
import nova.core.util.transform.vector.Vector2d;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

abstract class AbstractParagraph<T extends IText> implements IText, RenderedText {

	protected static Pattern wordSOL = Pattern.compile("^\\b[^\\s\n]+");
	protected static Pattern wordPattern = Pattern.compile("(%n|\n)|([^\\s]+(\\s|\n|%n))|\\s+|(.+)");

	protected List<Line<T>> lines = new ArrayList<>();
	protected Vector2d dimensions;

	protected void createDimensions() {
		double width = 0, height = 0;
		for (IText t2 : lines) {
			Vector2d dim = t2.getDimensions();
			width = Math.max(height, dim.x);
			height += dim.y;
		}
		dimensions = new Vector2d(width, height);
	}

	@Override
	public Vector2d getDimensions() {
		return dimensions;
	}
}