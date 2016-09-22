package consulo.freemarker;

import javax.swing.Icon;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.openapi.editor.highlighter.EditorHighlighter;
import com.intellij.openapi.fileTypes.EditorHighlighterProvider;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.FileTypeEditorHighlighterProviders;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import consulo.freemarker.highlight.FreeMarkerEditorHighlighter;
import consulo.freemarker.lang.FreeMarkerLanguage;

/**
 * User: Max
 * Date: 21.04.2007
 * Time: 14:36:31
 */
public class FreeMarkerFileType extends LanguageFileType
{
	public static final FreeMarkerFileType INSTANCE = new FreeMarkerFileType();

	protected FreeMarkerFileType()
	{
		super(FreeMarkerLanguage.INSTANCE);

		FileTypeEditorHighlighterProviders.INSTANCE.addExplicitExtension(this, new EditorHighlighterProvider()
		{
			@Override
			public EditorHighlighter getEditorHighlighter(@Nullable Project project, @NotNull FileType fileType, @Nullable VirtualFile virtualFile, @NotNull EditorColorsScheme colors)
			{
				return new FreeMarkerEditorHighlighter(project, virtualFile, colors);
			}
		});
	}

	@NotNull
	@NonNls
	public String getName()
	{
		return "FREE-MARKER";
	}

	@NotNull
	public String getDescription()
	{
		return "FreeMarker template";
	}

	@NotNull
	@NonNls
	public String getDefaultExtension()
	{
		return "ftl";
	}

	@Nullable
	public Icon getIcon()
	{
		return FreeMarkerIcons.FreeMarker;
	}
}


