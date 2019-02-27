package consulo.freemarker;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.NonNls;

import javax.annotation.Nullable;

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
import consulo.ui.image.Image;

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
			public EditorHighlighter getEditorHighlighter(@Nullable Project project, @Nonnull FileType fileType, @Nullable VirtualFile virtualFile, @Nonnull EditorColorsScheme colors)
			{
				return new FreeMarkerEditorHighlighter(project, virtualFile, colors);
			}
		});
	}

	@Nonnull
	@NonNls
	public String getId()
	{
		return "FREE-MARKER";
	}

	@Nonnull
	public String getDescription()
	{
		return "FreeMarker template";
	}

	@Nonnull
	@NonNls
	public String getDefaultExtension()
	{
		return "ftl";
	}

	@Nullable
	public Image getIcon()
	{
		return FreeMarkerIcons.FreeMarker;
	}
}


