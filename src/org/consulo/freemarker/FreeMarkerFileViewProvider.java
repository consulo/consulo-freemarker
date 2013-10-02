package org.consulo.freemarker;

import gnu.trove.THashSet;

import java.util.Arrays;
import java.util.Set;

import org.consulo.freemarker.lang.FreeMarkerLanguage;
import org.consulo.freemarker.lang.psi.FreeMarkerElementTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.lang.Language;
import com.intellij.lang.LanguageParserDefinitions;
import com.intellij.lang.html.HTMLLanguage;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.MultiplePsiFilesPerDocumentFileViewProvider;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.impl.source.PsiFileImpl;
import com.intellij.psi.templateLanguages.ConfigurableTemplateLanguageFileViewProvider;

/**
 * @author VISTALL
 * @since 02.10.13.
 */
public class FreeMarkerFileViewProvider extends MultiplePsiFilesPerDocumentFileViewProvider implements ConfigurableTemplateLanguageFileViewProvider
{
	public FreeMarkerFileViewProvider(PsiManager manager, VirtualFile virtualFile, boolean physical)
	{
		super(manager, virtualFile, physical);
	}

	@NotNull
	@Override
	public Language getBaseLanguage()
	{
		return FreeMarkerLanguage.INSTANCE;
	}

	@NotNull
	@Override
	public Language getTemplateDataLanguage()
	{
		return HTMLLanguage.INSTANCE;
	}

	@Nullable
	@Override
	protected PsiFile createFile(@NotNull Language lang)
	{
		if(lang == getBaseLanguage())
		{
			return createFileInner(lang);
		}
		if(lang == getTemplateDataLanguage())
		{
			final PsiFileImpl file = (PsiFileImpl) createFileInner(lang);
			file.setContentElementType(FreeMarkerElementTypes.TEMPLATE_DATA);
			return file;
		}
		return null;
	}

	private PsiFile createFileInner(Language lang)
	{
		return LanguageParserDefinitions.INSTANCE.forLanguage(lang).createFile(this);
	}

	@NotNull
	public Set<Language> getLanguages()
	{
		return new THashSet<Language>(Arrays.asList(getBaseLanguage(), getTemplateDataLanguage()));
	}

	@Override
	protected MultiplePsiFilesPerDocumentFileViewProvider cloneInner(VirtualFile fileCopy)
	{
		return new FreeMarkerFileViewProvider(getManager(), fileCopy, isPhysical());
	}
}
