package eu.paniw.timetable.components;

import java.util.Collection;
import java.util.List;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.IModel;

public class Palette<T> extends org.apache.wicket.extensions.markup.html.form.palette.Palette<T> {
	private static final long serialVersionUID = 5505904438560257567L;

	/**
	 * @param id
	 *            Component id
	 * @param choicesModel
	 *            Model representing collection of all available choices
	 * @param choiceRenderer
	 *            Render used to render choices. This must use unique IDs for
	 *            the objects, not the index.
	 * @param rows
	 *            Number of choices to be visible on the screen with out
	 *            scrolling
	 * @param allowOrder
	 *            Allow user to move selections up and down
	 */
	public Palette(String id, IModel<? extends Collection<? extends T>> choicesModel, IChoiceRenderer<T> choiceRenderer,
			int rows, boolean allowOrder) {
		super(id, choicesModel, choiceRenderer, rows, allowOrder);
	}

	/**
	 * @param id
	 *            Component id
	 * @param model
	 *            Model representing collection of user's selections
	 * @param choicesModel
	 *            Model representing collection of all available choices
	 * @param choiceRenderer
	 *            Render used to render choices. This must use unique IDs for
	 *            the objects, not the index.
	 * @param rows
	 *            Number of choices to be visible on the screen with out
	 *            scrolling
	 * @param allowOrder
	 *            Allow user to move selections up and down
	 */
	public Palette(String id, IModel<List<T>> model, IModel<? extends Collection<? extends T>> choicesModel,
			IChoiceRenderer<T> choiceRenderer, int rows, boolean allowOrder) {
		super(id, model, choicesModel, choiceRenderer, rows, allowOrder);
	}

	/**
	 * Returns the resource reference of the default stylesheet. You may return
	 * null to avoid using any stylesheet.
	 * 
	 * @return A resource reference
	 */
	protected ResourceReference getCSS() {
		return null;
	}
}
